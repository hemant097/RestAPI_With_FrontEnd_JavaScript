//populates the table in html with each row containing book and author information
function displayBooksForReaderInTable(data)
{
    document.querySelector("tbody").innerHTML=""
    data.forEach(function(ele){
        var tr=document.createElement("tr")
        var td1=document.createElement("td")
td1.innerText=ele.author;
      
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
         

        tr.append(td1,td4,td5,td6,td7,td8);
        document.querySelector("tbody").append(tr)
    })
}

    async function getAllBooks(){
        const url="http://localhost:8492/reader/book"
        
        let results;

        try{
            let res = await fetch(url);
    
            results= await res.json(); 
            
            console.log(results)

            if(results.length!=0)
            displayBooksForReaderInTable(results)
            else
            throw new Error(results.message)
        }
        catch(err){
          
          console.log(err)
      }
    }
   
    getAllBooks();
