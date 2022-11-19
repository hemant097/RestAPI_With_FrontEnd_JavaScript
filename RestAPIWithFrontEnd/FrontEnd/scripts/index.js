//populates the table in html with each row containing book and author information
function displayBooksInTable(data)
{
    document.querySelector("tbody").innerHTML=""
    data.forEach(function(ele){
        var tr=document.createElement("tr")
        var td1=document.createElement("td")
td1.innerText=ele.author;
        var td2=document.createElement("td")
td2.innerText=ele.author_no;
        var td3=document.createElement("td")
td3.innerText=ele.bookid;
        var td4=document.createElement("td")
td4.innerText=ele.category;
        var td5=document.createElement("td")
td5.innerText=ele.name;
        var td6=document.createElement("td")
td6.innerText=ele.pages; 
        var td7=document.createElement("td")
td7.innerText=ele.price; 
        var td8=document.createElement("td")
td8.innerText=ele.publication;
        var td9=document.createElement("td")
td9.innerText="Delete"; 
td9.style.color="red"
td9.style.cursor="pointer"
        td9.addEventListener("click",function(){
            deleteBook(ele.bookid);
        })   

        tr.append(td1,td2,td3,td4,td5,td6,td7,td8,td9);
        document.querySelector("tbody").append(tr)
    })
}

    async function getAllBooks(){
        const url="http://localhost:8492/author/book"
        
        let results;

        try{
            let res = await fetch(url);
    
            results= await res.json(); 
            
            console.log(results)

            if(results.length!=0)
            displayBooksInTable(results)
            else
            throw new Error(results.message)
        }
        catch(err){
          
          console.log(err)
      }
    }
   
    getAllBooks();

    
    //to delete a book
    function deleteBook(id){
        fetch(`http://localhost:8492/author/delete/${id}`,{
            method:"DELETE",
            headers:{
                "Content-type":"application/json"
            }
        }).then(response => response.json())
          .then(response => console.log(JSON.stringify(response)))
          .then( ()=> getAllBooks())
            //calling below function again to fetch updated list of books from DB, and append in HTML
            
        }