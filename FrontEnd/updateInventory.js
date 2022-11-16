document.querySelector("#adminForm").addEventListener("submit", catchFromForm);


function catchFromForm(){
    event.preventDefault();
    var formObj = {
            author: adminForm.author.value,
            author_no: adminForm.authorNum.value,
            price: parseInt(adminForm.price.value),
            category: adminForm.category.value,
            name: adminForm.bookName.value,
            pages: parseInt(adminForm.pages.value),
            publication: adminForm.publication.value,
        }
//console.log(formObj);
let bookid = adminForm.bookid.value;

        if(bookid.length==0)
        addBookInDB(formObj);
        else{
            formObj.bookid = bookid;
            updateBook(formObj,bookid);
        }
        
}

function addBookInDB(item){
    
    fetch("http://localhost:8492/author/savebook",{
            method:"POST",
            headers:{
                "Content-type":"application/json"
            },
            body:JSON.stringify(item)
        }).then(response => response.json())
          .then(response => console.log(JSON.stringify(response)))
          .then(()=> alert("Book added successfully"))
}


function updateBook(item,bookid){
    
    fetch(`http://localhost:8492/author/updatebook/${bookid}`,{
            method:"PUT",
            headers:{
                "Content-type":"application/json"
            },
            body:JSON.stringify(item)
        }).then(response => response.json())
          .then(response => console.log(JSON.stringify(response)))
          .then(()=> alert("Book updated successfully"))
}