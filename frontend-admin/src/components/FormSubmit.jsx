function FormSubmit({
  label, 
  ...rest
}) {
  return (
    <input type="submit" {...rest} value={label} />
  )
}

export default FormSubmit;