package kg.veatopus.practicminiapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.veatopus.practicminiapp.data.TaskRepositoryImpl
import kg.veatopus.practicminiapp.domain.model.Task
import kg.veatopus.practicminiapp.domain.use_case.CreateTask
import kg.veatopus.practicminiapp.domain.use_case.GetAllTasks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
	
	private val repository = TaskRepositoryImpl()
	
	private val createTaskUseCase = CreateTask(repository)
	private val getTasksUseCase = GetAllTasks(repository)
	
	private val _tasks = MutableLiveData<List<Task>>()
	val tasks: LiveData<List<Task>> = _tasks
	
	private val _error = MutableLiveData<String>()
	val error: LiveData<String> = _error
	
	fun create(
		title: String,
		desc: String,
	) {
		if (title.isEmpty()) {
			_error.postValue("title should not be empty")
			return
		}
		
		if (desc.isEmpty()) {
			_error.postValue("desc should not be empty")
			return
		}
		
		val id = System.currentTimeMillis()
		
		val task = Task(
			title = title,
			id = id,
			desc = desc
		)
		
		viewModelScope.launch(Dispatchers.IO) {
			createTaskUseCase.execute(task)
			_tasks.postValue(getTasksUseCase.execute())
		}
	}
	
}