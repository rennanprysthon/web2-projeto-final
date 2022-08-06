function FormInput({
  label,
  id,
  ...rest
}) {
  return (
    <div className="form__input">
      <label htmlFor={id}>{label}</label>
      <input type="text" id={id} {...rest}/>
    </div>
  )
}

export default FormInput