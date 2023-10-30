import { useEffect, useState } from "react";
import HomeTemplate from "../components/template/Home";

const HomePage = () => {
  const [products, setProducts] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/api/producto/listar")
      .then((result) => result.json())
      .then((result) => setProducts(result));
  }, []);

  return <HomeTemplate products={products} />;
};

export default HomePage;
