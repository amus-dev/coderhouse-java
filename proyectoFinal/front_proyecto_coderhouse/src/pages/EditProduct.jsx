import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import EditProductTemplate from "../components/template/EditProduct";

const EditProductPage = () => {
  const { productId } = useParams();
  const [product, setProduct] = useState(null);
  console.log(productId);

  useEffect(() => {
    fetch(`http://localhost:8080/api/producto/${productId}`)
      .then((result) => result.json())
      .then((result) => setProduct(result));
  }, []);

  return product && <EditProductTemplate product={product} />;
};

export default EditProductPage;
