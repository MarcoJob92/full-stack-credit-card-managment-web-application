import React, { useState, useEffect } from "react";
import $ from 'jquery-ajax';
import './App.css';
import Form from './components/Form';
import CardList from './components/CardList';
import ValidationErrors from './components/ValidationErrors';

const urlGetAll = "http://127.0.0.1:8080/creditCards/getAll";
const urlAdd = "http://127.0.0.1:8080/creditCards/add";


function App() {
  const [card, setCard] = useState({
          userName: '', number: '', limit: 0
  });
  const [validationErrors, setValidationErrors] = useState({
          userName: false, number: false, limit: false
  });
  const [cardList, setCardList] = useState([]);

  useEffect(() => {
    $.get(urlGetAll, response => setCardList(response));
  }, []);

  const handleInputChange = event => {
    let obj = {[event.target.name] : event.target.value};
    const updatedTask = Object.assign(card, obj);
    setCard({...updatedTask});
  }

  const isFormValid = () => {
    const nameRegex = /^[^0-9.]+$/;
    const limitRegex = /^[0-9]+$/;
    let errors = {userName: true, number: true, limit: true};
    if (nameRegex.test(card.userName))
      errors.userName = false;
    if (checkCardNumber())
      errors.number = false;
    if (limitRegex.test(card.limit) && card.limit >= 100)
      errors.limit = false;
    setValidationErrors(errors);
    return !Object.values(errors).some(error => error === true);
  }

  const checkCardNumber = () => {
    const number = card.number.replace(/ /g,'').replace(/-/g,'');
    return number.length >= 16 && number.length <= 19 
          && checkLuhn10(number);
  }  

  const checkLuhn10 = number => {
    let sum = 0;
    for (let i=0; i<number.length; i++){
      let digit = Number(number.charAt(i));
      if (i % 2 === 0) {
        digit *= 2;
        if (digit > 9)
          digit -= 9;
      }
      sum += digit;
    }
    return (sum % 10) === 0;
  }

  const addCard = () => {
    if (isFormValid()){
      $.ajax({
        url:urlAdd,
        type:"POST",
        data:JSON.stringify(card),
        contentType:"application/json;charset=utf-8",
        success: function(r){
          setCardList( [...cardList, card] );
          setCard({userName: '', number: '', limit: ''});
        },
        error: function(xhr, status, error){
          if (xhr.status === 409) {
            alert("A Credit Card with that number already exists!");
          } else {
            alert("A service error occurred, please try again later!");
          }
        }
      });
    }
  }

  return (
    <div className="App">
      <h1>Credit Card System</h1>
      <p> Use the form below to add a new Credit Card to the System </p>

      <Form card={card} 
            handleInputChange={handleInputChange}
            addCard={addCard} />

      <ValidationErrors errors={validationErrors} />

      <CardList cards={cardList} />

    </div>
  );
}

export default App;
