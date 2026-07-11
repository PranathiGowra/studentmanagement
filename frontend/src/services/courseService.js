import API from "../api/axios";

export const getCourses = () =>
    API.get("/courses");

export const addCourse = (course) =>
    API.post("/courses", course);

export const updateCourse = (id, course) =>
    API.put(`/courses/${id}`, course);

export const deleteCourse = (id) =>
    API.delete(`/courses/${id}`);