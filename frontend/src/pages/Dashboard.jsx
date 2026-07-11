import { useNavigate } from "react-router-dom";

function Dashboard() {

    const navigate = useNavigate();

    const logout = () => {

        localStorage.clear();
        navigate("/login");

    };

    return (

        <div className="container mt-5">

            <div className="card shadow-lg p-5">

                <h1 className="text-primary">

                    🎓 Student Course Management

                </h1>

                <hr />

                <h3>

                    Welcome 👋

                </h3>

                <p>

                    You have successfully logged into the system.

                </p>

                <div className="row mt-4">

                    <div className="col-md-4">

                        <div className="card text-center shadow p-4">

                            <h2>📚</h2>

                            <h4>Courses</h4>

                            <button
                                className="btn btn-primary mt-3"
                                onClick={() => navigate("/courses")}
                            >
                                View Courses
                            </button>

                        </div>

                    </div>

                    <div className="col-md-4">

                        <div className="card text-center shadow p-4">

                            <h2>🎯</h2>

                            <h4>My Courses</h4>

                            <button
                                className="btn btn-success mt-3"
                                onClick={() => navigate("/my-courses")}
                            >
                                Open
                            </button>

                        </div>

                    </div>

                    <div className="col-md-4">

                        <div className="card text-center shadow p-4">

                            <h2>🚪</h2>

                            <h4>Logout</h4>

                            <button
                                className="btn btn-danger mt-3"
                                onClick={logout}
                            >
                                Logout
                            </button>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    );

}

export default Dashboard;