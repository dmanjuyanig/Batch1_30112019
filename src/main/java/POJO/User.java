package POJO;

public class User {
	
	private String name;
	private String job;
	
	public User(String name , String job)
	{
		this.job = job;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
