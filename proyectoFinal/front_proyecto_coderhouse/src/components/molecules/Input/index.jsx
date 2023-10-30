import "./styles.input.css";

const Input = ({ type, id, placeholder, value, onChange }) => {
  return (
    <input
      className="input"
      type={type}
      name={id}
      id={id}
      placeholder={placeholder}
      value={value}
      onChange={(e) => onChange(e.target.value)}
    />
  );
};

export default Input;
