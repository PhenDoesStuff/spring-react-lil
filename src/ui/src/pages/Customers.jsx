import React, { useLayoutEffect, useState } from 'react';

const Customers = () => {
    const [customers, setCustomers] = useState([]);

    useLayoutEffect(() => {
        const getCustomers = async () => {
            const res = await fetch('/api/customers');
            const customers = await res.json();
            setCustomers(customers);
        };
        getCustomers().catch(e => {
            console.log('Error fetching customers: ' + e);
        })
    });

    return (
        <table>
            <thead>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email Address</th>
            <th>Phone Number</th>
            <th>Address</th>
            </thead>
            <tbody>
            {customers.map(customer => {
                const { address, customerId, emailAddress, firstName, lastName, phoneNumber } = customer;
                return (
                    <tr key={customerId}>
                        <td>{customerId}</td>
                        <td>{firstName}</td>
                        <td>{lastName}</td>
                        <td>{emailAddress}</td>
                        <td>{phoneNumber}</td>
                        <td>{address}</td>
                    </tr>
                );
            })}
            </tbody>
        </table>
    );
};

export default Customers;