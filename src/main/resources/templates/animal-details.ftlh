<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
    <title>View ${animal.name}</title>
    <link rel="icon" href="/page/pawprint.jpg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <!-- fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&family=Space+Mono:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
</head>

<body>
  <!-- Begin Nav Bar -->
    <ul class="navigation space-mono-bold">
         <li>
            <a href="/animals" class="navlink">HOME</a>
         </li>
      </ul>
<!-- End Nav Bar -->

  <main class="animal-page space-mono">
    <h1 class="space-mono-bold">View Details of the ${animal.name}</h1>
    <div class="detail-gallery">
      <section class="details-card">
        <img src="/profile-pictures/${(animal.animalPicturePath)!'default.jpg'}" alt="">
      </section>
      <section class="detail-section-coffee">
        <p class="">BIO: ${animal.description}</p>
        <p> LIFESPAN: ${animal.lifespan} years</p>
        <p> HABITAT: ${animal.habitat}</p>
        <a href="/animals${'/updateForm/'+(animal.animalID)!'/'}">
          <button class="light center">Edit ${animal.name}</button>
        </a>
      </section>
    </div>

    


  </main>

</body>

</html>