
document.querySelector("#readerForm").addEventListener("submit", catchFromForm);

let searchQuery;

function catchFromForm(){
    event.preventDefault();
    searchQuery = readerForm.searchQ.value;
    console.log(searchQuery);

    getBookByName(searchQuery);
}

function append(items){
    let container=document.getElementById("container")
    container.innerHTML=null;
    items.forEach(data=>{
    let bookName=document.createElement("h1")
    bookName.innerText= data.name;

    let pages=document.createElement("p");
    pages.innerText="Pages - "+data.pages;

    let price=document.createElement("p");
    price.innerText="Pages - "+data.price;

    let author=document.createElement("p");
    author.innerText="Author - "+data.author;
    
    let publication=document.createElement("p");
    publication.innerText="Publication - "+data.publication;
    
    let category=document.createElement("p");
    category.innerText="Category - "+data.category;
    
    let div=document.createElement("div");
    div.append(bookName,author,category,publication,pages,price);

    container.append(div);
    })
    

}



async function getBookByName(searchQuery){
    const url=`http://localhost:8492/reader/book/find/${searchQuery}`;
    
    let result;

    try{
        let res = await fetch(url);

        result= await res.json(); 
        
        console.log(result)

        if(result.length!=0)
        append(result)
        else
        throw new Error(result.message)
    }
    catch(err){
      
      console.log(err)
  }
}

