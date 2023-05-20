import { useLayoutEffect, useState } from 'react';
import { getCurrency } from '../Utils';

const Services = () => {
    const [services, setServices] = useState([]);

    useLayoutEffect(() => {
        const getProducts = async () => {
            const res = await fetch('/api/services')
            const services = await res.json();
            setServices(services)
        }
        getProducts().catch(e => {
            console.log('Error fetching services: ' + e);
        })
    })

    return (
        <table>
            <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Vendor ID</th>
            </thead>
            <tbody>
            {services.map(service => {
                const {serviceId, name, price, vendorId} = service;
                return (
                    <tr key={serviceId}>
                        <td>{serviceId}</td>
                        <td>{name}</td>
                        <td>{getCurrency(price)}</td>
                    </tr>
                )
            })}
            </tbody>
        </table>
    )
}

export default Services;