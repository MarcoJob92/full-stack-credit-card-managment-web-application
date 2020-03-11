import React from 'react';


const Table = props => {
  return (
    <table className="table">
      <thead className="thead-dark">
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Card Number</th>
          <th scope="col">Balance</th>
          <th scope="col">Limit</th>
        </tr>
      </thead>
      <tbody>
        {
          props.cards.map(card =>
            <tr key={card.number}>
              <td> {card.userName} </td>
              <td> {formatNumber(card.number)} </td>
              <td> £0 </td>
              <td> {card.limit} </td>
            </tr>
          )
        }
      </tbody>
    </table>
  );
}

const formatNumber = number => {
  return number.replace(/ /g,'')
               .replace(/-/g,'')
               .replace(/(.{4})/g,"$1 ");
}

export default Table;
