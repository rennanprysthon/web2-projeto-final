import React from 'react'
import ReactDOM from 'react-dom/client'
import { BrowserRouter } from 'react-router-dom';
import './css/reset.scss'
import RouterWrapper from './RouterWrapper';

const container = document.getElementById('root');
ReactDOM.createRoot(container).render(
  <BrowserRouter>
    <RouterWrapper />
  </BrowserRouter>
)
