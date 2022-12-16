   window.addEventListener("load", function() {
                  fetch("https://api.apify.com/v2/datasets/vVEzi6r5accfotWgL/items?token=apify_api_nLwbQJPgk5R4bgU3iH70EtD9GtO8W63yA7WM").then(function(response){
                response.json().then(function(json){
                const div= document.getElementById("listings");
                const newContainer= document.getElementById("container");
                for(let i=0; i < 100; i++){
                newContainer.innerHTML +=`
                <div class="tab-content">
                    <div id="tab-1" class="tab-pane fade show p-0 active">
                        <div class="job-item p-4 mb-4">
                              <div class="row g-4">
                                  <div class="col-sm-12 col-md-8 d-flex align-items-center">
                                          <div class="text-start ps-4">
                                              <h5 class="mb-3">${json[i].positionName}</h5>
                                                  <span class="text-truncate me-3"><i class="fa fa-map-marker-alt text-primary me-2"></i>${json[i].location}</span>
                                                  <span class="text-truncate me-3"><i class="far fa-clock text-primary me-2"></i>${json[i].jobType[0]}</span>
                                                  <span class="text-truncate me-0"><i class="far fa-money-bill-alt text-primary me-2"></i>${json[i].salary}</span>
                                                    </div>
                                  </div>
                        <div class="col-sm-12 col-md-4 d-flex flex-column align-items-start align-items-md-end justify-content-center">
                <div class="d-flex mb-3">
                        <a class="btn btn-light btn-square me-3" href="/saveJob"><i class="far fa-heart text-primary"></i></a>
                        <a class="btn btn-primary" href="${json[i].url}">Apply Now</a>
                      </div>
             <small class="text-truncate"><i class="far fa-calendar-alt text-primary me-2"></i>${json[0].postedAt}</small>
              </div>
             </div>
            </div>

            `;

 }

});
});
});









