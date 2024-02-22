package kg.veatopus.practicminiapp.domain

import kg.veatopus.practicminiapp.domain.model.Task

interface TaskRepository {
	
	suspend fun createTask(task: Task)
	
	suspend fun getTasks() : List<Task>
	
}