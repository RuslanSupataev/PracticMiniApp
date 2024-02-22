package kg.veatopus.practicminiapp.data

import kg.veatopus.practicminiapp.domain.TaskRepository
import kg.veatopus.practicminiapp.domain.model.Task
import kotlinx.coroutines.delay

class TaskRepositoryImpl : TaskRepository {
	
	private val dataStore = DataStore
	
	override suspend fun createTask(task: Task) {
		delay(1_000L)
		dataStore.add(task)
	}
	
	override suspend fun getTasks(): List<Task> {
		delay(1_000L)
		return dataStore.getAll()
	}
	
}