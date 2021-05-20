import { Link } from 'react-router-dom'
import './Order.css'
import { Fade } from 'react-awesome-reveal'

class Order extends Component {

    async addOrder(id) {
        const requestOptions = {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ drink: "Espresso", milk: "Whole", size: "Tall" })
        };
        const r = await fetch(`/api/order/register/${id}`, requestOptions);
        const body = await r.json();
        this.setState({ result: body, isLoading: false });
    };

    render() {

        return (
            <Fade>
                <Link className='item' onClick={() => this.addOrder(99)}>
                    <img src={this.props.image} alt='' className='item_image' />
                    <h4 className='item_type'>{this.props.type}</h4>
                </Link>
            </Fade>
        );
    }
}

export default Order