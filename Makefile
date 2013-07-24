# Check style:
proof:
	echo "weasel words: "
	sh bin/weasel **/*.tex
	echo
	echo "passive voice: "
	sh bin/passive **/*.tex
	echo
	echo "duplicates: "
	perl bin/dup **/*.tex

# Install jekyll
setup:
	gem install jekyll

# Build html site, github does this automatically for us
build:
	jekyll

# Run a basic http server to make it easy to view the site
server: build
	jekyll --server 8282 --auto --base-url "/slcc-eportfolio"
