import { useLayoutEffect, useState } from 'react';
import { getCurrency } from '../Utils';

const Vendors = () => {
    const [vendors, setVendors] = useState([]);

    useLayoutEffect(() => {
        const getVendors = async () => {
            const res = await fetch('/api/vendors');
            const vendors = await res.json();
            setVendors(vendors);
        };
        getVendors().catch(e => {
            console.log('Error fetching vendors: ' + e);
        });
    });

    return (
        <table>
            <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Vendor ID</th>
            </thead>
            <tbody>
            {vendors.map(vendor => {
                const { vendorId, name, price, contact, phoneNumber, emailAddress, address } = vendor;
                return (
                    <tr key={vendorId}>
                        <td>{vendorId}</td>
                        <td>{name}</td>
                        <td>{getCurrency(price)}</td>
                        <td>{contact}</td>
                        <td>{phoneNumber}</td>
                        <td>{emailAddress}</td>
                        <td>{address}</td>
                    </tr>
                );
            })}
            </tbody>
        </table>
    );
};

export default Vendors;