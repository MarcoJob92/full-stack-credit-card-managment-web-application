import React from 'react';


const ValidationErrors = props => {
  return (
    <div className="validation-errors">
      {props.errors.userName &&
        <div className="alert">
          User Name field cannot contain numbers or be empty.
        </div>
      }
      {props.errors.number &&
        <div className="alert">
          Card Number not valid. It must be a 16 to 19 digit number and should work against Luhn 10 algorithm.
        </div>
      }
      {props.errors.limit &&
        <div className="alert">
          Limit field must be a valid number and greater or equeal to 100.
        </div>
      }
    </div>
  )
}

export default ValidationErrors;
