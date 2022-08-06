import { NavLink } from "react-router-dom";
import "../css/components/Navigation.scss";
function Navigation() {
  return (
    <nav className="navigation">
      <ul>
        <li>
          <NavLink 
            className={({isActive}) => 
              isActive ? '--active' : ''
            }
            to="donatario"
          >
            Cadastrar orgaos donatários
          </NavLink>
        </li>
        <li>
          <NavLink 
            className={({isActive}) => 
              isActive ? '--active' : ''
            }
            to="fiscalizador"
          >
            Cadastrar orgaos fiscalizadores
          </NavLink>
        </li>
        <li>
          <NavLink 
            className={({isActive}) => 
              isActive ? '--active' : ''
            }
            to="lotes"
          >
            Cadastrar lotes
          </NavLink>
        </li>
      </ul>
    </nav>
  );
}

export default Navigation;
