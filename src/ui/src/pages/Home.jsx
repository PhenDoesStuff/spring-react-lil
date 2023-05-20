import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <div>
            <h3>Admin</h3>
            <ul style={{listStyleType: 'none'}}>
                <li>
                    <Link to={'/customers'}>Customers</Link>
                </li>
            </ul>
        </div>
    );
};

export default Home;