import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { register } from "../services/authService";

function Register() {

    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        password: ""
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            await register(formData);

            alert("Registration Successful");

            navigate("/login");

        } catch (err) {

            alert("Registration Failed");

        }

    };

    return (

        <div className="container mt-5">

            <div className="row justify-content-center">

                <div className="col-md-5">

                    <div className="card shadow p-4">

                        <h2 className="text-center mb-4">

                            Register

                        </h2>

                        <form onSubmit={handleSubmit}>

                            <input
                                className="form-control mb-3"
                                placeholder="Name"
                                name="name"
                                onChange={handleChange}
                            />

                            <input
                                className="form-control mb-3"
                                placeholder="Email"
                                name="email"
                                onChange={handleChange}
                            />

                            <input
                                type="password"
                                className="form-control mb-3"
                                placeholder="Password"
                                name="password"
                                onChange={handleChange}
                            />

                            <button
                                className="btn btn-success w-100">

                                Register

                            </button>

                        </form>

                        <p className="text-center mt-3">

                            Already have an account?

                            <Link to="/login">

                                Login

                            </Link>

                        </p>

                    </div>

                </div>

            </div>

        </div>

    );

}

export default Register;