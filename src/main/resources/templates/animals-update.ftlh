<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
    <title>Update ${animal.name}</title>
    <link rel="icon" href="/page/pawprint.jpg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <!-- fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&family=Space+Mono:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
</head>
<body>
</head>

<body>

  <!-- Begin Nav Bar -->
    <ul class="navigation space-mono-bold">
            <li>
            <a href="/animals" class="navlink">HOME</a>
            </li>
        </ul>
<!-- End Nav Bar -->

  <div class="container" style="margin-top: 15px;">
    <h1>${title}</h1>
    <form id="new-animal" action="/animals/update/${animal.animalID?c}" method="post" enctype="multipart/form-data">
      <input type="text" id="animalID" name="animalID" value="${animal.animalID?c}" readonly />
      <input type="text" id="name" name="name" value="${animal.name}" placeholder="Name" />
      <input type="text" id="habitat" name="habitat" value="${animal.habitat}" placeholder="Your Backyard" />
      <input type="text" id="lifespan" name="lifespan" value="${animal.lifespan}" placeholder="LifeSpan" />
      <textarea type="text" id="description" name="description" value="${animal.description}" placeholder="Description"></textarea>
      <label for="profilePicturePath" class="form-label">${animal.name}'s Current Picture</label>
      <img src="/profile-pictures/${(animal.animalPicturePath)!'default.jpg'}" alt="" class="mini">
      <input type="text" id="animalPicturePath" name="animalPicturePath" value="${(animal.animalPicturePath)}" readonly />
      <input type="file" id="picture" name="picture" />
      <button type="submit" class="btn btn-primary">Save</button>
      <a href="/animals${'/id/'+(animal.animalID)!'/'}" class="light center">Cancel</a>
    </form>

  </div>
</body>

</html>