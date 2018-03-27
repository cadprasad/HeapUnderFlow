export const ACTION_TYPES = {
    ADDED_BLOG: 'added_blog',
    UPDATED_BLOG: 'updated_blog',
    REMOVED_BLOG: 'removed_blog',
    FETCHED_BLOGS: 'fetched_blogs',
    FETCHED_BLOG_BY_ID: 'fetched_blog_by_id'
}

let baseurl = "http://localhost:8080/heapunderflow/service/"

export function addBlog(blogDetails) {
    console.log(`Blog details $blogDetails`)
    return {
        type: ACTION_TYPES.ADDED_BLOG,
        blogDetails: blogDetails
    };
}

export function fetchBlogs(blogs) {
    console.log("fetchBlogs");
    return {
        
        type: ACTION_TYPES.FETCHED_BLOGS,
        blogs: blogs,
    };
}

export function fetchBlogById(blog) {
    console.log("fetchBlogById");
    return {
        type: ACTION_TYPES.FETCHED_BLOG_BY_ID,
        blog: blog,
    };
}

export function fetchBlogsFromServer() {
    console.log("fetchBlogsFromServer")
    return (dispatch) => {
        fetch("http://localhost:8080/heapunderflow/service/" + "blog")
        .then((response) => {
                return response.json();
        }).then((blogs) => dispatch(fetchBlogs(blogs)));
    };
}

export function fetchBlogByIdFromServer(blogId) {
    console.log("fetchBlogsFromServer")
    return (dispatch) => {
        fetch("http://localhost:8080/heapunderflow/service/" + "blog/" + blogId)
        .then((response) => {
                return response.json();
        }).then((blog) => dispatch(fetchBlogbyId(blog)));
    };
}

export function addBlogtoServer(blog){
    console.log("addBlogtoServer")
    return (dispatch) => {
        fetch(baseurl + "userId" + "blog/add", {
              method: 'post',
              headers: {
                  'Content-Type':'application/json',
              },
              body: JSON.stringify({
                blogTitle: blog.blogTitle,
                blogAuthor: blog.blogAuthor,
                blogText: blog.blogText,
                blogCreation: blog.blogCreation
              })
          }).then(function(response){
              console.log("Response received"+ JSON.stringify(response))
              return dispatch(addBLog(blog));
          });
      }
    }
