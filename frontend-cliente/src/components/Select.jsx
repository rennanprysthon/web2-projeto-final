import '../css/components/Select.scss';

const Select = ({id, values, setDonatarioSelected}) => {
  function onHandleChange({target}) {
    let id = target.value;
    if (id == '-1') return;

    setDonatarioSelected(target.value) 
  }

  return (
    <div className='select'>
      <select id={id} onChange={onHandleChange} className="select">
        <option value="-1">
          Escolha uma opção
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

export default Select