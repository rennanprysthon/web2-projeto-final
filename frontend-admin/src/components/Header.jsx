import '../css/components/Header.scss'
import Navigation from './Navigation'

function Header() {
  return (
    <header className='header'>
      <h1 className='header__title'>Admin view</h1>
      <Navigation />
    </header>
  )
}

export default Header