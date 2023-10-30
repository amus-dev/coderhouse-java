import { useState } from "react";
import Button from "../../molecules/Button";
import Input from "../../molecules/Input";
import "./styles.editproduct.css";
import { Link } from "react-router-dom";
import { BASE_URL_API } from "../../../config/index";

const EditProductTemplate = ({ product }) => {
  const [nombre, setNombre] = useState(product.nombre);
  const [descripcion, setDescripcion] = useState(product.descripcion);
  const [precio, setPrecio] = useState(product.precio);
  const [image, setImage] = useState(product.imagePath);

  const handleEditar = () => {
    fetch(`${BASE_URL_API}/producto/editar/${product.id}`, {
      method: "PUT", // or 'PUT'
      body: JSON.stringify({
        nombre,
        descripcion,
        imagePath: image,
        precio,
      }), // data can be `string` or {object}!
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then(() => alert("Editado con exito"))
      .catch((error) => console.error("Error:", error))
      .then((response) => console.log("Success:", response));
  };

  return (
    product && (
      <div className="boxForm">
        <h1 className="title">Editar Producto</h1>
        <div className="boxForm__content">
          <Input
            type="text"
            id="name"
            placeholder="Nombre"
            value={nombre}
            onChange={(text) => setNombre(text)}
          />
          <Input
            type="text"
            id="name"
            value={descripcion}
            onChange={(text) => setDescripcion(text)}
          />
          <Input
            type="number"
            id="name"
            value={precio}
            onChange={(text) => setPrecio(text)}
          />
          <Input
            type="text"
            id="name"
            value={image}
            onChange={(text) => setImage(text)}
          />
          <Button text="Editar" onClick={handleEditar} />
          <Link to="/">Volver</Link>
        </div>
      </div>
    )
  );
};

export default EditProductTemplate;
