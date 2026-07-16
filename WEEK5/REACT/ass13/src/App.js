import "./App.css";

import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

import { books, blogs, courses } from "./Data";

function App() {

  return (

    <div className="container">

      <div className="box">

        <CourseDetails courses={courses} />

      </div>

      <div className="box">

        <BookDetails books={books} />

      </div>

      <div className="box">

        <BlogDetails blogs={blogs} />

      </div>

    </div>

  );

}

export default App;