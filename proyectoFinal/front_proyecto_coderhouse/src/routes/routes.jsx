import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "../pages/Home";
import Products from "../pages/Products";
import SingleProduct from "../pages/SingleProduct";
import EditProduct from "../pages/EditProduct";

const RoutesNav = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/products" element={<Products />} />
        <Route path="/products/:productId" element={<SingleProduct />} />
        <Route path="/edit/:productId" element={<EditProduct />} />
      </Routes>
    </BrowserRouter>
  );
};

export default RoutesNav;
