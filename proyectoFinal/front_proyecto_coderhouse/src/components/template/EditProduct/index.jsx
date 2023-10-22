import Button from "../../molecules/Button";
import Input from "../../molecules/Input";
import "./styles.editproduct.css";
const EditProductTemplate = () => {
  return (
    <div className="boxForm">
      <h1 className="title">Editar Producto</h1>
      <div className="boxForm__content">
        <Input type="text" id="name" placeholder="Nombre" value="Pastel" />
        <Input type="text" id="name" placeholder="Descripción" />
        <Input type="number" id="name" placeholder="Precio" />
        <Button text="Agregar" />
      </div>
    </div>
  );
};

export default EditProductTemplate;
