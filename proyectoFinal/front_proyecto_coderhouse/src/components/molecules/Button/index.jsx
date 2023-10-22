const Button = ({ text, onClick }) => {
  return (
    <button className="button button-eliminar raleway" onClick={onClick}>
      {text}
    </button>
  );
};

export default Button;
