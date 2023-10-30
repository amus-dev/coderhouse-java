import { useEffect, useState } from "react";
import HomeTemplate from "../components/template/Home";
import { BASE_URL_API } from "../config/index";

const HomePage = () => {
  const [products, setProducts] = useState(null);

  useEffect(() => {
    fetch(`${BASE_URL_API}/producto/listar`)
      .then((result) => result.json())
      .then((result) => setProducts(result));
  }, []);

  return <HomeTemplate products={products} />;
};

export default HomePage;
