<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!doctype html>
    <html lang="en">

    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>

    <body>
        <main class="container">
            <section class="row">
                <div class="offset-3 col-6">
                    <form action="/ASSJV4/share" method="post">
                    	<input type="hidden" name="videoID" value="${videoID }">
                        <div class="card">
                            <div class="card-header">
                                Send Video
                            </div>
                            <div class="card-body">
                            <span>${message }</span>
                                <div class="form-group">
                                    <label for="email">Your Friend email</label>
                                    
                                    <input type="text" class="form-control" name="email" id="email"
                                        aria-describedby="emailID" placeholder="Emails">
                                    <small id="emailID" class="form-text text-muted">Email is requird</small>
                                </div>
                            </div>
                            <div class="card-footer">
                            	<button type="submit" formaction="/ASSJV4/share">Send</button>
                            </div>
                        </div>
                    </form>
                </div>
            </section>

        </main>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    </body>

    </html>