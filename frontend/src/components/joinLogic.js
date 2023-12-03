export const login = ({ setIsValid, userName, navigate }) => {
  fetch(`http://localhost:8080/createUser/${userName}`, {
    method: "POST",
  })
    .then((result) => {
      if (!result.ok) {
        throw new Error("Username is taken!");
      }
      return result.text();
    })
    .then((data) => {
      if (typeof window !== undefined) {
        window.localStorage.setItem("user", data);
        setIsValid(true);
        navigate("/posts/chat");
      }
    })
    .catch((error) => {
      console.log("Error ", error);
      setIsValid(false);
    });
};
