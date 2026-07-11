import API from "../api/axios";

export const enroll = (data) =>
    API.post("/enrollments", data);

export const myCourses = (studentId) =>
    API.get(`/enrollments/student/${studentId}`);