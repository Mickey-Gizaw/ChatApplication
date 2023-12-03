import React from "react";
import ReactDOM from "react-dom";
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom"

import "./index.css";
import App from "./App";
import { Chat } from "./routes/Chat";

const router = createBrowserRouter([
    {
        path: "/",
        element:<App />,
    },
    {
        path: "/posts/chat",
        element:<Chat />,
    },
]);

ReactDOM.render(
  <React.StrictMode>
      <RouterProvider router={router} />
  </React.StrictMode>,
  document.getElementById("root")
);
