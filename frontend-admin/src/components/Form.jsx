import {useRef} from 'react'

function Form({children, onSubmit}) {
  const formRef = useRef(null);
  function onHandleSubmit(event) {
    event.preventDefault();
    const jsonValues = Array.from(formRef.current.querySelectorAll('.form__input input'))
      .reduce((prev, next) => {
        return {
          ...prev, 
          ...{
            [next.id]: next.value
          }
        }
    }, {})

    const selectValues = Array.from(formRef.current.querySelectorAll('.form__select'))
    .filter(element => element.value != '-1')
    .reduce((prev, next) => {
        return {
            ...prev,
            ...{
              [next.id]: next.value
            }
        }
    } ,{})

    onSubmit({...jsonValues, ...selectValues})
    formRef.current.reset()
  }

  return (
    <form 
      ref={formRef}
      onSubmit={onHandleSubmit}
    >
      {children}
    </form>
  )
}

export default Form;