import logo from './logo.svg';
import './App.css';
import {Card, Col, Container, Navbar} from "react-bootstrap";
import {BrowserRouter as Router,Routes ,Route} from 'react-router-dom'
import Login from "./pages/login";
import Home from "./pages/Home";
import DataFetch, {setAuthToken} from "./controller/dataFetch";
import SideNav from "./components/SideNav";
import React from "react";
import MainCardSidebar from "./components/MainCardSidebar";
import MainCardNoSide from "./components/MainCardNoSide";

function App() {
    new DataFetch().init(); // initiate datafetch

  return (
      <Router>


        <div className="App">
            <Navbar style={{zIndex:"150"}} bg="dark" variant="dark">
              <Container>
                <Navbar.Brand href="/home">
                  <img
                      alt=""
                      src="/logo.svg"
                      width="30"
                      height="30"
                      className="d-inline-block align-top"
                  />{' '}
                  Paymentino
                </Navbar.Brand>
              </Container>
            </Navbar>

          <Container fluid={true}>
              <Routes>
                  <Route path="/login" element={<MainCardNoSide element={<Login/>}/>}/>
                  <Route path="/" element={<MainCardSidebar element={<Home/>}/>}/>
              </Routes>


          </Container>
        </div>
      </Router>
  );
}

export default App;
