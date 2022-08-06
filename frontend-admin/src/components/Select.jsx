import {memo} from 'react'
const Select = ({id, values, label}) => {
  return (
    <div>
      <select id={id} className="form__select">
        <option value="-1">
          {label || "Escolha uma opção"}
        </option>
        {
          values.map(val => 
            (
              <option key={val.id} value={val.id}>{val.nome}</option>
            )
          )
        }
      </select>
    </div>
  )
}

export default memo(Select)