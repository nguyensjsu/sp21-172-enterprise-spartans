import './App.css';
import React, { useEffect, Component } from "react";
import Home from './Home/Home.js';
import Header from './Home/Header/Header.js'
import MenuScreen from './Menu/MenuScreen.js';
import RewardsScreen from './Rewards/RewardsScreen.js';
import GiftScreen from './Gifts/GiftScreen.js';
import Footer from './Home/Footer/Footer.js';

import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";

class App extends Component {

  state = {
    isLoading: true,
    orders: []
  };

  async componentDidMount() {
    const response = await fetch('/api/orders');
    const body = await response.json();
    this.setState({ orders: body, isLoading: false });
  }

  render() {

    const { orders, isLoading } = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <Router>
          <Switch>
            <Route exact path="/">
              <Header></Header>
              {orders.map(order =>
                <div key={order.id}>
                  {order.total}
                </div>
              )}
              <Home></Home>
              <Footer></Footer>
            </Route>
            <Route exact path="/menu">
              <Header></Header>
              <MenuScreen />
              <Footer></Footer>
            </Route>
            <Route exact path="/gifts">
              <Header></Header>
              <GiftScreen />
              <Footer></Footer>
            </Route>
            <Route exact path="/rewards">
              <Header></Header>
              <RewardsScreen />
              <Footer></Footer>
            </Route>
          </Switch>
        </Router>
      </div>
    );
  }
}

export default App;
