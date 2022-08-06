import {
  Routes,
  Route
} from "react-router-dom";
import App from "./App";

import OrgaoDonatario from './pages/OrgaoDonatario';
import OrgaoFiscalizador from './pages/OrgaoFiscalizador';
import Lote from './pages/Lote';

function RouterWrapper () {
 return (
    <Routes>
      <Route path="/" element={<App />}>
        <Route path="donatario" element={<OrgaoDonatario />} />
        <Route path="fiscalizador" element={<OrgaoFiscalizador />} />
        <Route path="lotes" element={<Lote />} />
      </Route>
    </Routes>
 )
}

export default RouterWrapper;