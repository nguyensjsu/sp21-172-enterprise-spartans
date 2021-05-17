import './App.css';
import React, { useEffect } from "react";
import Home from './Home/Home.js';
import Header from './Home/Header/Header.js'
import MenuScreen from './Menu/MenuScreen.js';
import RewardsScreen from './Rewards/RewardsScreen.js';
import GiftScreen from './Gifts/GiftScreen.js';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/">
            <Header></Header>
            <Home></Home>
          </Route>
          <Route exact path="/menu">
            <Header></Header>
            <MenuScreen />
          </Route>
          <Route exact path="/gifts">
            <Header></Header>
            <GiftScreen />
          </Route>
          <Route exact path="/rewards">
            <Header></Header>
            <RewardsScreen />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
