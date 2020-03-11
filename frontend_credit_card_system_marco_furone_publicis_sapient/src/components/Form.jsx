import React from 'react';


const Form = props => {
  return (
    <div className="form">
      <label> Name </label>
      <input type="text" name="userName"
             value={props.card.userName}
             onChange={props.handleInputChange} />
      <label> Card number </label>
      <input type="text" name="number"
             value={props.card.number}
             onChange={props.handleInputChange} />
      <label> Limit </label>
      <input type="number" name="limit"
             value={props.card.limit}
             onChange={props.handleInputChange} />
      <button onClick={props.addCard}> Add </button>
    </div>
  );
}

export default Form;
