import { useEffect, useState } from "react";
import { getCourses } from "../services/courseService";
import { enroll } from "../services/enrollmentService";

function Courses() {

    const [courses, setCourses] = useState([]);

    useEffect(() => {
        loadCourses();
    }, []);

    const loadCourses = async () => {
        try {
            const response = await getCourses();
            setCourses(response.data);
        } catch (error) {
            console.error(error);
            alert("Failed to load courses");
        }
    };

    const handleEnroll = async (courseId) => {

        try {

            await enroll({
                studentId: 1,
                courseId: courseId
            });

            alert("🎉 Course Enrolled Successfully!");

        } catch (error) {

            console.error(error);
            alert("Enrollment Failed");

        }

    };

    return (
        <div className="container mt-5">

            <h2 className="mb-4">📚 Available Courses</h2>

            <div className="row">

                {courses.map((course) => (

                    <div className="col-md-4 mb-4" key={course.courseId}>

                        <div className="card shadow h-100">

                            <div className="card-body">

                                <h4>{course.title}</h4>

                                <p>{course.description}</p>

                                <p>
                                    <strong>Instructor:</strong> {course.instructor}
                                </p>

                                <p>
                                    <strong>Duration:</strong> {course.duration} Hours
                                </p>

                                <p className="text-success fw-bold">
                                    ₹ {course.price}
                                </p>

                                <button
                                    className="btn btn-success w-100"
                                    onClick={() => handleEnroll(course.courseId)}
                                >
                                    Enroll
                                </button>

                            </div>

                        </div>

                    </div>

                ))}

            </div>

        </div>
    );
}

export default Courses;