
# Do not show commands
options(echo=FALSE)

# Read script parameters
args <- commandArgs(trailingOnly = TRUE)

# Enable if debugging
# print(args)

# Read arguments into variables
start_date <- as.Date(args[1])
name <- paste("output/", args[2], sep="")
n <- as.integer(args[3])
rm(args)

# Compute data
x <- rnorm(n)

# Create the png image and plot the data
print(paste("Writing ", name, ".png", sep=""))

png(paste(name, ".png", sep=""))
plot(start_date+(1L:n), x)

# Close the file
garbage <- dev.off()

summary(x)

