class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/"(view:"/index")
        "/login/$action?"(controller: "login")
        "/logout/$action?"(controller: "logout")
        "/"(controller: 'post', action: "blog")
        "500"(view:'/error')
	}
}
