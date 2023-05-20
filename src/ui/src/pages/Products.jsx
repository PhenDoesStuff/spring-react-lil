import { useLayoutEffect, useState } from 'react';

const Products = () => {
    const [products, setProducts] = useState([]);
    const [vendors, setVendors] = useState(new Map());

    const add = (key, value) => {
        setVendors(prevState => new Map([...prevState, [key, value]]));
    };

    useLayoutEffect(() => {
        const getProducts = async () => {
            const res = await fetch('/api/products');
            const products = await res.json();
            setProducts(products);
        };
        const getVendors = async () => {
            const res = await fetch('/api/vendors');
            const vendors = await res.json();
            vendors.map(vendor => {
                const { vendorId } = vendor;
                add(vendorId, vendor);
            });
        };
        getProducts().catch(e => {
            console.log('Error fetching products: ' + e);
        });
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
            <th>Vendor Name</th>
            </thead>
            <tbody>
            {products.map(product => {
                const { productId, name, price, vendorId } = product;
                return (
                    <tr key={productId}>
                        <td>{productId}</td>
                        <td>{name}</td>
                        <td>{price}</td>
                        <td>{vendors.get(vendorId).name}</td>
                    </tr>
                );
            })}
            </tbody>
        </table>
    );
};

export default Products;